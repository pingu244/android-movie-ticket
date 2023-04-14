package woowacourse.movie.movielist

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import woowacourse.movie.R
import woowacourse.movie.domain.movieinfo.Movie
import woowacourse.movie.domain.movieinfo.RunningDate
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpMovieDatas()
    }

    private fun setMovieData(): List<Movie> = listOf(
        Movie(
            title = "해리포터",
            runningDate = RunningDate(LocalDate.of(2024, 3, 1), LocalDate.of(2024, 4, 1)),
            runningTime = 200,
            description = getString(R.string.description),
            moviePoster = R.drawable.img,
        ),
    )

    private fun setUpMovieDatas() {
        val movieListView = findViewById<ListView>(R.id.movie_listView)
        val movieListViewAdapter = MovieListViewAdapter(this, setMovieData())

        movieListView.adapter = movieListViewAdapter
    }
}
