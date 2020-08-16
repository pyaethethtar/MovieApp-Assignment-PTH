package com.example.movieapp.mvp.presenters.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.movieapp.data.model.MockMovieModelImpl
import com.example.movieapp.data.model.MovieModel
import com.example.movieapp.data.model.MovieModelImpl
import com.example.movieapp.dummy.getDummyGenres
import com.example.movieapp.dummy.getDummyMovies
import com.example.movieapp.dummy.getDummyPeople
import com.example.movieapp.dummy.getDummyVideos
import com.example.movieapp.mvp.presenters.MainPresenterImpl
import com.example.movieapp.mvp.views.MainView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {

    private lateinit var mPresenter: MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MainView

    private lateinit var mMovieModel: MovieModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)

        MovieModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mMovieModel = MockMovieModelImpl

        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMovieModel = this.mMovieModel
    }

    @Test
    fun onUiReady_callDisplayAllList(){
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mPresenter.onUiReady(lifecycleOwner)
        verify {
            mView.displayPopularMovies(getDummyMovies())
            mView.displaySliderImages(getDummyMovies())
            mView.displayShowcases(getDummyMovies())
            mView.displayGenresList(getDummyGenres())
            mView.displayBestActors(getDummyPeople())
        }
    }

    @Test
    fun onTapGenre_callDisplayMoviesByGenre(){
        val genreId = 3
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mPresenter.onTabGenre(lifecycleOwner, genreId)
        verify {
            mView.displayMoviesByGenres(getDummyMovies().filter {
                it.genreIds.contains(genreId)
            })
        }
    }

    @Test
    fun onTapMovieItem_callNavigateToDetails(){
        val tappedMovieId = 3
        mPresenter.onTapPopularMovieItem(tappedMovieId)
        verify {
            mView.navigateToMovieDetails(tappedMovieId)
        }
    }

    @Test
    fun onTapPlay_callPlayTrailerVideo(){
        val tappedMovieId = 1
        mPresenter.onTapPlay(tappedMovieId)
        verify {
            mView.playTrailerVideo(getDummyVideos().first())
        }
    }

}