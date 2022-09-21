package com.configurator.Interfaces;
import java.util.*;

public interface  IInvoiceService {
            public IInvoiceService set(IInvoiceService val);

    public List<IInvoiceService> get();

    public IInvoiceService get(UUID id);

    public void delete(IInvoiceService val);

    public void delete(UUID id);
}
