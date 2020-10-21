package com.finnax.finnaxApp.services;

import java.util.UUID;

import com.finnax.finnaxApp.entities.Interest;
import com.finnax.finnaxApp.entities.Product;

public interface IProductService extends CrudService<Product>{

	Product findByIdOriginal(UUID id)throws Exception;
}
