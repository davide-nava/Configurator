package com.configurator.Interfaces;
import java.util.*;

public interface  IInvoiceItemService {
               public IInvoiceItemService set(IInvoiceItemService val);

    public List<IInvoiceItemService> get();

    public IInvoiceItemService get(UUID id);

    public void delete(IInvoiceItemService val);

    public void delete(UUID id);
}
