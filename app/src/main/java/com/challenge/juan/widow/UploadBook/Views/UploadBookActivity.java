package com.challenge.juan.widow.UploadBook.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.challenge.juan.widow.Models.Book;
import com.challenge.juan.widow.R;
import com.challenge.juan.widow.UploadBook.Presenters.IUploadBookPresenter;
import com.challenge.juan.widow.UploadBook.Presenters.UploadBookPresenter;

import java.util.Map;

public class UploadBookActivity extends AppCompatActivity implements IUploadBookActivity {

    IUploadBookPresenter presenter;
    Button uploadBookButtom;
    EditText bookTitle;
    EditText authorName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_book);
        presenter = new UploadBookPresenter(this);

        uploadBookButtom = findViewById(R.id.Button_upload_book);
        bookTitle = findViewById(R.id.editText_book_title);
        authorName = findViewById(R.id.editText_book_author);

        Init();
    }

    private void Init() {
        uploadBookButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadBook();
            }
        });
    }

    public void uploadBook() {
        Book book = getBookData();
        presenter.uploadBook(book);
    }

    private Book getBookData() {
        Book book = new Book();
        String bookTitleString = bookTitle.getText().toString().trim();
        String authorNameString = authorName.getText().toString().trim();
        book.setTitle(bookTitleString);
        book.setAuthor(authorNameString);
        return  book;
    }

    @Override
    public void Toast(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }
}
