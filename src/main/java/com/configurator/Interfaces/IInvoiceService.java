package com.configurator.Interfaces;
import com.configurator.Entities.InvoiceEntity;

import java.util.*;

public interface  IInvoiceService {
            public InvoiceEntity set(InvoiceEntity val);

    public List<InvoiceEntity> get();

    public InvoiceEntity get(UUID id);

    public void delete(InvoiceEntity val);

    public void delete(UUID id);
}
