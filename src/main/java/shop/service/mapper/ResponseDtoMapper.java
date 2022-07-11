package shop.service.mapper;

public interface ResponseDtoMapper<D, M> {
    D toDto(M model);
}
