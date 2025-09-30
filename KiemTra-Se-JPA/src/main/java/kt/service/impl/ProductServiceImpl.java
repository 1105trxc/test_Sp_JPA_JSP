package kt.service.impl;

import java.util.List;

import kt.entity.Seller;
import kt.repsitory.SellerRepository;
import kt.service.ProductService;

public class ProductServiceImpl implements ProductService {
  private final SellerRepository sellerRepo = new SellerRepository();

  @Override
  public List<Seller> listBySeller() {
    return sellerRepo.findAllWithProducts();
  }
}