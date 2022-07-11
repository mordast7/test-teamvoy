package shop.service.mapper;

public interface RequestDtoMapper<M, D> {
    M toModel(D dto);
}
