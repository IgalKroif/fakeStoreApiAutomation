package fakeStoreApi.apiRunner;

import fakeStoreApi.storeProducts.GET.TestAllProducts;
import org.junit.platform.suite.api.*;


@Suite
@SuiteDisplayName("My Test Suite")
@SelectClasses({TestAllProducts.class}) // Use only the package name

//@IncludeTags({"GET"})
public class TestSuites {

}