package sh.christian.ozone.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import io.kamel.core.Resource
import io.kamel.image.asyncPainterResource

@Composable
fun PostImage(
  modifier: Modifier = Modifier,
  imageUrl: String?,
  contentDescription: String?,
  onClick: () -> Unit,
  fallbackColor: Color = Color.Transparent,
) {
  if (imageUrl != null) {
    when (val resource = asyncPainterResource(imageUrl)) {
      is Resource.Failure,
      is Resource.Loading -> {
        EmptyPostImage(fallbackColor)
      }
      is Resource.Success -> {
        Image(
          modifier = modifier
            .clip(MaterialTheme.shapes.large)
            .clickable { onClick() },
          painter = resource.value,
          contentDescription = contentDescription,
          contentScale = ContentScale.Crop,
        )
      }
    }
  } else {
    EmptyPostImage(fallbackColor, modifier)
  }
}

@Composable
private fun EmptyPostImage(
  fallbackColor: Color,
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier
      .clickable { }
      .clip(MaterialTheme.shapes.large)
      .background(fallbackColor)
  )
}
