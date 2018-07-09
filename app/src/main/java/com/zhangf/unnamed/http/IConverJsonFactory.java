package com.zhangf.unnamed.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created on 2017/7/30.
 */

public class IConverJsonFactory extends Converter.Factory {
    private final Gson gson;
    private IConverJsonFactory(Gson gson){
        this.gson = gson;
    }
    public static IConverJsonFactory create(){
        return create(new GsonBuilder().setLenient().create());
    }
    public static IConverJsonFactory create(Gson gson){
        if(gson == null){
            throw new NullPointerException("gson == null");
        }
        return new IConverJsonFactory(gson);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new IResponseBodyConverter<>(gson,adapter);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new IRequestBodyConverter<>(gson,adapter);
    }


}
