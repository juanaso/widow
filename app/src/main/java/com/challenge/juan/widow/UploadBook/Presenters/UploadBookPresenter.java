package com.challenge.juan.widow.UploadBook.Presenters;

import android.view.View;

import com.challenge.juan.widow.Models.Book;
import com.challenge.juan.widow.UploadBook.Interactors.IUploadBookInteractor;
import com.challenge.juan.widow.UploadBook.Interactors.UploadBookInteractor;
import com.challenge.juan.widow.UploadBook.Views.IUploadBookActivity;
import com.challenge.juan.widow.UploadBook.Views.UploadBookActivity;

public class UploadBookPresenter implements IUploadBookPresenter {

    IUploadBookInteractor interactor;
    IUploadBookActivity view;

    public UploadBookPresenter(UploadBookActivity view) {
        this.view = view;
        interactor = new UploadBookInteractor(this,view);
    }

    @Override
    public void uploadBook(Book book) {
        interactor.uploadBook(book);
    }

    @Override
    public void Toast(String message) {
        view.Toast(message);
    }
}
