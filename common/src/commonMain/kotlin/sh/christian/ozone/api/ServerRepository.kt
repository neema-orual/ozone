package sh.christian.ozone.api

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import me.tatarka.inject.annotations.Inject
import sh.christian.ozone.di.SingleInApp
import sh.christian.ozone.login.auth.Server
import sh.christian.ozone.store.PersistentStorage
import sh.christian.ozone.store.getValue
import sh.christian.ozone.store.preference
import sh.christian.ozone.store.setValue

@Inject
@SingleInApp
class ServerRepository(
  storage: PersistentStorage,
) {
  private val serverPreference = storage.preference<Server>("servers", Server.BlueskySocial)

  var server by serverPreference
  fun server(): Flow<Server> = serverPreference.updates.filterNotNull()
}
