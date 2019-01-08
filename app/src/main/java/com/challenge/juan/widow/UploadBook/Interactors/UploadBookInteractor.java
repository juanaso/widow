package com.challenge.juan.widow.UploadBook.Interactors;

import com.challenge.juan.widow.FireBase.FireBaseDataBaseManager;
import com.challenge.juan.widow.Models.Book;
import com.challenge.juan.widow.UploadBook.Presenters.IUploadBookPresenter;
import com.challenge.juan.widow.UploadBook.Presenters.UploadBookPresenter;
import com.challenge.juan.widow.UploadBook.Views.UploadBookActivity;


public class UploadBookInteractor extends FireBaseDataBaseManager implements IUploadBookInteractor {

    IUploadBookPresenter presenter;

    public UploadBookInteractor(UploadBookPresenter presenter, UploadBookActivity view) {
        this.presenter = presenter;
    }

    @Override
    public void handleErrorMessage(String message) {
        presenter.Toast(message);
    }

    @Override
    public void uploadBook(Book book) {
        super.uploadBook(book);
    }
}
