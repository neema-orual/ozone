package sh.christian.ozone.user

import app.bsky.actor.ProfileView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import sh.christian.ozone.api.ApiProvider
import sh.christian.ozone.app.Supervisor

class MyProfileRepository(
  private val apiProvider: ApiProvider,
  private val userDatabase: UserDatabase,
) : Supervisor {
  private val profileFlow = MutableStateFlow<ProfileView?>(null)

  @OptIn(ExperimentalCoroutinesApi::class)
  override suspend fun CoroutineScope.onStart() {
    apiProvider.auth().flatMapLatest { auth ->
      auth?.handle
        ?.let { handle -> userDatabase.profile(UserReference.Handle(handle)) }
        ?: flowOf(null)
    }.collect(profileFlow)
  }

  fun me(): Flow<ProfileView?> = profileFlow
}
