package com.project.commodity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.commodity.payload.response.ErrorResponse;




@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(BrandServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleBrandServiceException(BrandServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(CategoryServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleCategoryServiceException(CategoryServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(CouponServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleCouponServiceException(CouponServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(ProductServiceCustomExcePtion.class)
    public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceCustomExcePtion exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ProductCategoryServiceCusromException.class)
    public ResponseEntity<ErrorResponse> handleProductCategoryServiceException(ProductCategoryServiceCusromException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ProductOptionServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleProductOptionServiceException(ProductOptionServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(OptionValueServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleOptionValueServiceException(OptionValueServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(ProductSaleServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleProductSaleServiceException(ProductSaleServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(ProductGallaryServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleProductGallaryServiceException(ProductGallaryServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(OptionServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handlOptionServiceException(OptionServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(TagServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handlTagServiceException(TagServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ProductTagServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handlProductTagServiceException(ProductTagServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ProductFeedBackServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handlProductFeedbackServiceException(ProductFeedBackServiceCustomException exception){
        return new ResponseEntity<>(ErrorResponse.builder()
        .errorMessage(exception.getErrorCode())
        .errorCode(exception.getErrorCode())
        .build(), HttpStatus.NOT_FOUND);

    }

}
