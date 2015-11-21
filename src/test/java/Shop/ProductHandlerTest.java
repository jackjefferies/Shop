//package Shop;
//
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import static org.mockito.Mockito.*;
//
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import spark.Request;
//import spark.Response;
//
//import static org.junit.Assert.*;
//
///**
// * Created by Jack on 17/11/2015.
// */
//@RunWith(MockitoJUnitRunner.class)
//public class ProductHandlerTest {
//
//    @Mock
//    private Request request;
//    @Mock
//    private Response response;
//
//    ProductDao productDao = new ProductDao();
//
//
//    @Test
//    public void testAddItem() throws Exception {
//
//        when(request.params(":product")).thenReturn("pickle");
//        when(request.params(":stock")).thenReturn("1");
//        when(request.params(":price")).thenReturn("1.00");
//
//        ProductHandler productHandler = new ProductHandler(productDao);
//
//        String responseGiven = productHandler.handle(request, response).toString();
//
//        assertEquals("pickle added", responseGiven);
//    }
//
//    @Test
//    public void testAddItemWithoutPriceShouldFail() throws Exception {
//
//        when(request.params(":product")).thenReturn("pickle");
//        when(request.params(":stock")).thenReturn("1");
//        when(request.params(":price")).thenReturn("0.00");
//
//        ProductHandler productHandler = new ProductHandler(productDao);
//
//        String responseGiven = productHandler.handle(request, response).toString();
//
//        assertEquals("no price", responseGiven);    }
//}