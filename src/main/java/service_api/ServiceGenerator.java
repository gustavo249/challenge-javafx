package service_api;

public interface ServiceGenerator {
    <S> S createService(Class<S> serviceClass);
}
