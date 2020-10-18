package com.example.liberary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private static final String TAG = "BookActivity";

    private TextView bookName, authorName, description , pageNumber;
    private ImageView bookImage;
    private Button btnCurReading , btnWantToRead , btnAlreadyRead;

    private Book incomingBook;
    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidget();

        Intent intent = getIntent();
        int id = intent.getIntExtra("bookId",0);
        util= new Util();
        ArrayList<Book> books= util.getAllBooks();
        for (Book b: books){
            if (b.getId() == id){

                incomingBook = b;
                bookName.setText(b.getName());
                authorName.setText(b.getAuthor());
                description.setText(b.getDescription());
                pageNumber.setText("Pages: "+ b.getPages());

                Glide.with(this).asBitmap().load(b.getImageUrl()).into(bookImage);
            }
        }

        btnCurReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCurReadingTapped();
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlreadyReadTapped();
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWantToReadTapped();
            }
        });

    }

//btn for btn want ro read click
    private void btnWantToReadTapped(){
        Log.d(TAG, "btnWantToReadTapped: stared");

        ArrayList<Book> wantToReadBooks = util.getWantToReadBooks();

        if(wantToReadBooks.contains(incomingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You Already Added This book to your want To Read List");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }else {

            ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();
            if(alreadyReadBooks.contains(incomingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("you Already read this book");
                builder.setTitle("Error");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(false);
                builder.create().show();

            }else {
                ArrayList<Book> currentlyReadingBook = util.getCurrentlyReadingBooks();
                if ( currentlyReadingBook.contains(incomingBook)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("you Already readهدل this book");
                    builder.setTitle("Error");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setCancelable(false);
                    builder.create().show();

                }else {

                    util.addWantToReadBooks(incomingBook);
                    Toast.makeText(this, "THe Book" + incomingBook.getName() + "Added to your want To Read", Toast.LENGTH_SHORT).show();
                }
            }

        }

    }

//btn for btn Already READ
    private void btnAlreadyReadTapped(){
        Log.d(TAG, "btnAlreadyReadTapped: start");

        ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();

        if(alreadyReadBooks.contains(incomingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You Already Added This book to your Already Reading List");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }else {

            ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();
            if(currentlyReadingBooks.contains(incomingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Have you finish reading this book?");
                builder.setTitle("Error");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.removeCurrentlyReadingBook(incomingBook);
                        util.addAlreadyReadBooks(incomingBook);
                        Toast.makeText(BookActivity.this, "THe Book" + incomingBook.getName() + "Added to your Already reading", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(false);
                builder.create().show();
            }else {
                util.addAlreadyReadBooks(incomingBook);
                Toast.makeText(this, "THe Book" + incomingBook.getName() + "Added to your Already reading", Toast.LENGTH_SHORT).show();
            }

        }

    }

//btn for btn currently reading
    private void btnCurReadingTapped() {
        Log.d(TAG, "btnCurReadingTapped: started");

        ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();

        if(currentlyReadingBooks.contains(incomingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You Already Added This book to your Currently Reading List");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }else {

            ArrayList<Book> wantToReadBooks = util.getWantToReadBooks();

            if(wantToReadBooks.contains(incomingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you going to start reading this book?");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.removeWantToReadBooksk(incomingBook);
                        util.addCurrentlyReadingBooks(incomingBook);
                        Toast.makeText(BookActivity.this, "THe Book" + incomingBook.getName() + "Added to your currebt reading", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setCancelable(true);
                builder.create().show();
            }else {
                ArrayList<Book> alreadyReadBook = util.getAlreadyReadBooks();
                if(alreadyReadBook.contains(incomingBook)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("do u want read it again?");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            util.addCurrentlyReadingBooks(incomingBook);
                            Toast.makeText(BookActivity.this, "THe Book" + incomingBook.getName() + "Added to your currebt reading", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setCancelable(true);
                    builder.create().show();

                }else {
                    util.addCurrentlyReadingBooks(incomingBook);
                    Toast.makeText(this, "THe Book" + incomingBook.getName() + "Added to your currebt reading", Toast.LENGTH_SHORT).show();
                }
            }


        }
    }

    private void initWidget(){
        bookName = findViewById(R.id.bookName);
        authorName = findViewById(R.id.authorName);
        description = findViewById(R.id.bookDesc);
        pageNumber = findViewById(R.id.bookPages);
        bookImage = findViewById(R.id.bookImage);
        btnWantToRead = findViewById(R.id.btnWantToRead);
        btnAlreadyRead = findViewById(R.id.btnAlredyReade);
        btnCurReading = findViewById(R.id.btnCurReading);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}