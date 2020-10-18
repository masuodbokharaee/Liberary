package com.example.liberary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private static final String TAG = "AllBooksActivity";

    private RecyclerView booksRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d(TAG, "onCreate: started");

        booksRecView = findViewById(R.id.booksRecView);

        BooksRecViewAdapter adapter = new BooksRecViewAdapter(this);
        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new GridLayoutManager(this , 2));


//        books.add(new Book("1Q84", "Haruki Murakami",1350,"https://m.media-amazon.com/images/I/417qN9YA3QL._SY346_.jpg","a work od maddening brilliance koft"));
//        books.add(new Book("Iliad", "Homer",1000,"https://images-na.ssl-images-amazon.com/images/I/51evlbp3ZHL._SX344_BO1,204,203,200_.jpg","Greek Heroes and maddening brilliance koft"));
//        books.add(new Book("Beyond good and evil", "Nietzsche",350,"https://images-na.ssl-images-amazon.com/images/I/51YSf4h9tEL._SX331_BO1,204,203,200_.jpg","Greek Heroes and maddening brilliance koft"));

        Util util = new Util();
        ArrayList<Book> books = new ArrayList<>();
        books = util.getAllBooks();
        adapter.setBooks(books);
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
        return super.onContextItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}