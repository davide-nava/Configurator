package com.configurator.Interfaces;
import com.configurator.Entities.InvoiceItemEntity;

import java.util.*;

public interface  IInvoiceItemService {
               public InvoiceItemEntity set(InvoiceItemEntity val);

    public List<InvoiceItemEntity> get();

    public InvoiceItemEntity get(UUID id);

    public void delete(InvoiceItemEntity val);

    public void delete(UUID id);
}
