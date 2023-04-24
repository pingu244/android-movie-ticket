package woowacourse.movie.view.movielist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import woowacourse.movie.R
import woowacourse.movie.view.moviedetail.MovieDetailActivity
import woowacourse.movie.view.viewmodel.DummyData
import woowacourse.movie.view.viewmodel.MovieListData.ADData
import woowacourse.movie.view.viewmodel.MovieUIModel

class MovieListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        setUpMovieRecyclerView()
    }

    private fun setUpMovieRecyclerView() {
        val movieRecyclerView = findViewById<RecyclerView>(R.id.movie_recyclerView)
        val movieAdapter = MovieRecyclerAdapter(
            DummyData.getItems(),
            object : MovieRecyclerAdapter.OnClickItem {
                override fun onClick(movie: MovieUIModel) {
                    val intent = MovieDetailActivity.newIntent(this@MovieListActivity, movie)
                    startActivity(intent)
                }
            },
            ::clickAdvertisement
        )

        movieRecyclerView.layoutManager = LinearLayoutManager(this)
        movieRecyclerView.adapter = movieAdapter
    }

    private fun clickAdvertisement(ad: ADData) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ad.url))
        startActivity(intent)
    }
}
