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
import com.example.movieapp.mvp.presenters.DetailsPresenterImpl
import com.example.movieapp.mvp.views.DetailsView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class DetailsPresenterImplTest {

    private lateinit var mPresenter : DetailsPresenterImpl

    @RelaxedMockK
    private lateinit var mView : DetailsView

    private lateinit var mMovieModel: MovieModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)
        MovieModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mMovieModel = MockMovieModelImpl

        mPresenter = DetailsPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMovieModel = this.mMovieModel
    }

    @Test
    fun onDetailsUiReady_callDisplayMovieDetailsAndLists(){
        val movie = getDummyMovies().first()
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mPresenter.onDetailsUiReady(lifecycleOwner, movie.id)
        verify {
            mView.displayMovieDetails(movie)
            mView.displayStoryline(movie)
            mView.displayAboutFilm(movie)
            mView.displayActors(getDummyPeople())
            mView.displayCreators(getDummyPeople())
        }
    }

    @Test
    fun onTapBack_callGoToMain(){
        mPresenter.onTapBack()
        verify { mView.goBackToMain() }
    }

    @Test
    fun onTapFavMovie_callSetFavMovie(){
        mPresenter.onTapFavMovie()
        verify { mView.setFavMovie() }
    }
}