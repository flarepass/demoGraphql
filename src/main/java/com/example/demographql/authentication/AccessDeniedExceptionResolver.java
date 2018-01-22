//package com.example.demographql.authentication;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
//
//@Configuration
//@Order(HIGHEST_PRECEDENCE)
//public class AccessDeniedExceptionResolver implements HandlerExceptionResolver
//{
////    private int order;
//
//    @Override
//    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
//                                         Object handler, Exception exception)
//    {
//        if(exception instanceof AccessDeniedException)
//        {
//            System.out.println("aaaaaaaggg");
//            return new ModelAndView("redirect:/login"); //Replace with redirect to your login-page
//        }
//        System.out.println("bbbbbbbbbb");
//
//        return null; //Null-return = pass the exception to next handler in order
//    }
//
////    public void setOrder(int order)
////    {
////        this.order = order;
////    }
////
////    @Override
////    public int getOrder()
////    {
////        return order;
////    }
//}
