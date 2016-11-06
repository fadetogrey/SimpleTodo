package com.example.fonda.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.fonda.simpletodo.R.id.etEditText;

public class EditItemActivity extends AppCompatActivity {
    public final int RESULT_OK = 200;
    public final String ITEM_ORIGINAL = "originalItem";
    public final String ITEM_MODIFIED = "modifiedItem";
    public final String ITEM_POSITION = "itemPosition";

    EditText etEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String selectedItem = getIntent().getStringExtra(ITEM_ORIGINAL);
        etEditText = (EditText) findViewById(R.id.etItemToEdit);
        etEditText.setText(selectedItem);
    }

    public void onSave(View view) {

        Intent data = new Intent();
        // pass back data as a result
        data.putExtra(ITEM_MODIFIED, etEditText.getText().toString());
        data.putExtra(ITEM_POSITION, getIntent().getIntExtra(ITEM_POSITION, -1));
        setResult(RESULT_OK, data);
        finish();
    }
}
