package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Items> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO ItemsDAO;
	private Utils utils;

	public ItemsController(ItemsDAO ItemsDAO, Utils utils) {
		super();
		this.ItemsDAO = ItemsDAO;
		this.utils = utils;

	}

	@Override
	public List<Items> readAll() {
		List<Items> items = ItemsDAO.readAll();
		for (Items item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	@Override
	public Items create() {
		LOGGER.info("Please enter name (enter exit to cancel)");
		String name = utils.getString();
		if(name.equals("exit")) {
			LOGGER.info("Cancelling request");
			return null;
		}
		LOGGER.info("Please enter price (enter 0 to cancel)");
		Double price = utils.getDouble();
		if(price.equals(0d)) {
			LOGGER.info("Cancelling request");
			return null;
		}
		Items items = ItemsDAO.create(new Items(name, price));
		LOGGER.info("Item created");
		return items;
	}

	@Override
	public Items update() {
		LOGGER.info("Please enter ID of item you would like to update");
		Long IID = utils.getLong();
		if(IID.equals(-1l)) {
			return null;
		}
		LOGGER.info("Please enter name");
		String name = utils.getString();
		LOGGER.info("Please enter price");
		Double price = utils.getDouble();
		Items items = ItemsDAO.update(new Items(IID, name, price));
		LOGGER.info("Item Updated");
		return items;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter ID of Item you would like to delete");
		Long IID = utils.getLong();
		LOGGER.info("Item Deleted");
		return ItemsDAO.delete(IID);
	}

}
