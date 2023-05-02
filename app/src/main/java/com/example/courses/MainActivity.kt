package com.example.courses

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courses.Data.DataSource
import com.example.courses.Data.DataSource.topics
import com.example.courses.model.Grid
import com.example.courses.ui.theme.CoursesTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicGrid()
                }
            }
        }
    }
}
@Composable
fun TopicGrid (modifier: Modifier = Modifier) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement =
            Arrangement.spacedBy(8.dp),
        horizontalArrangement =
            Arrangement.spacedBy(8.dp)

    )
    {
       items(DataSource.topics) { topic ->
           TopicCard(topic)

       }
    }

}






@Composable
fun TopicCard(grid: Grid,modifier: Modifier = Modifier) {
  Card()
      {
      Row {
          Box{
              Image(
                  modifier = modifier
                      .size(width = 68.dp, height = 68.dp)
                      .aspectRatio(1f),
                  contentScale = ContentScale.Crop,
                  painter = painterResource(id = grid.imageRes), contentDescription = "${grid.name}"
              )
          }

          Column() {

              Text(text = stringResource(id = grid.name),
                  modifier = Modifier
                      .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp),
                  style = MaterialTheme.typography.bodyMedium,
                  fontWeight = FontWeight.Bold

              )

              Row(verticalAlignment = Alignment.CenterVertically) {


                  Icon(painter = painterResource(id = R.drawable.ic_grain), contentDescription = null,
                  modifier = Modifier
                      .padding(start = 16.dp , end = 8.dp))


                  Text(text = grid.numberOfCourses.toString(),
                      style = MaterialTheme.typography.labelMedium,)

              }
          }
      }
  }

}

@Preview(showBackground = true)
@Composable
fun TopicPreview() {
    CoursesTheme {
        val grid = Grid(R.string.photography,321,R.drawable.photography)

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            TopicCard(grid  = grid )
            
        }

    }
}