package fakeStoreApi.apiRunner;

import fakeStoreApi.storeCarts.GET.TestAllCarts;
import fakeStoreApi.storeProducts.GET.TestAllProducts;
import org.junit.platform.suite.api.*;


@Suite
@SuiteDisplayName("My Test Suite")
@IncludeEngines("junit-jupiter")
//@SelectClasses({TestAllCarts.class}) // Use only the package name
//@SelectPackages({"fakeStoreApi.storeCarts.GET", "fakeStoreApi.storeProducts.GET"})

@IncludeTags({"GET", "get", "Get"})
public class TestSuites {

}