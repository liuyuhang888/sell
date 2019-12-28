package com.liuyuhang.sell.service.impl;/**
 * @Auther: 刘宇航
 * @Date: 2019/11/17 14:04
 * @Description:
 */

import com.liuyuhang.sell.dataobject.ProductInfo;
import com.liuyuhang.sell.dto.CartDTO;
import com.liuyuhang.sell.enums.ProductStatusEnum;
import com.liuyuhang.sell.enums.ResultEnum;
import com.liuyuhang.sell.exception.SellException;
import com.liuyuhang.sell.repository.ProductInfoRepository;
import com.liuyuhang.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: liuyuhang
 * @time: 2019/11/17 14:04
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable); //分页查询，返回page对象
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo one = repository.findOne(productId);
        if (one == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (one.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        one.setProductStatus(ProductStatusEnum.UP.getCode());

        return repository.save(one);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo one = repository.findOne(productId);
        if (one == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (one.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        one.setProductStatus(ProductStatusEnum.DOWN.getCode());

        return repository.save(one);
    }

    @Override
    @Transactional
    public void delete(Integer productType) {
        try {
            repository.deleteByCategoryType(productType);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }

    }

    @Override
    public List<ProductInfo> findByCategoryType(Integer categoryType) {

        return repository.findByCategoryType(categoryType);
    }

}
