package com.code44.finance.ui.currencies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.code44.finance.R;
import com.code44.finance.db.model.Currency;
import com.code44.finance.providers.BaseModelProvider;
import com.code44.finance.providers.CurrenciesProvider;
import com.code44.finance.ui.ModelEditFragment;

public class CurrencyEditFragment extends ModelEditFragment<Currency> {
    private EditText code_ET;

    public static CurrencyEditFragment newInstance(long currencyId) {
        final Bundle args = makeArgs(currencyId);

        final CurrencyEditFragment fragment = new CurrencyEditFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_currency_edit, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get view
        code_ET = (EditText) view.findViewById(R.id.code_ET);
    }

    @Override
    public boolean onSave() {
        return false;
    }

    @Override
    protected Class<? extends BaseModelProvider<Currency>> getModelProviderClass() {
        return CurrenciesProvider.class;
    }

    @Override
    protected Class<Currency> getModelClass() {
        return Currency.class;
    }

    @Override
    protected void onModelLoaded(Currency model) {
        code_ET.setText(model.getCode());
    }
}
