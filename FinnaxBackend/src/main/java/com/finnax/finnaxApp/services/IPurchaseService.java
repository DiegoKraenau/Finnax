package com.finnax.finnaxApp.services;

import java.util.UUID;

import com.finnax.finnaxApp.entities.Interest;
import com.finnax.finnaxApp.entities.Product;
import com.finnax.finnaxApp.entities.Purchase;

public interface IPurchaseService  extends CrudService<Purchase>{

	Purchase findByIdOriginal(UUID id)throws Exception;
}
