package com.restaurant.util.interfaces;

import java.util.ArrayList;

import com.restaurant.model.document.Menu;

public interface PdfGeneratosInter {

  public byte[] createInvoice(ArrayList<Menu> listMenus);

}
