package com.rz.alon.doordashlite;

import com.rz.alon.doordashlite.models.RestaurantModel;
import com.rz.alon.doordashlite.network.NetworkCalls;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCallYieldedDataTest {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGettingRestaurantList() {
        // TODO add test
    }
}
