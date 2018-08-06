package com.rz.alon.doordashlite.presenters;

import com.rz.alon.doordashlite.models.RestaurantModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import retrofit2.Call;

public class RestaurantListPresenterTest {

    private Contracts.RestaurantListView view;
    private RestaurantListPresenter presenter;

    @Before
    public void setUp() throws Exception {
        view = Mockito.mock(Contracts.RestaurantListView.class);
        presenter = new RestaurantListPresenter();
    }

    @Test
    public void doGetRestaurantList() {
        Contracts.RestaurantListAgent mockListAgent = Mockito.mock(Contracts.RestaurantListAgent.class);
        Call<List<RestaurantModel>> call = Mockito.mock(Call.class);
        // TODO: unfinished test here
    }

}