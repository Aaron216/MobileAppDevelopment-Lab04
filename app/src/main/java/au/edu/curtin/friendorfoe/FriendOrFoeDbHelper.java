package au.edu.curtin.friendorfoe;

import au.edu.curtin.friendorfoe.FriendOrFoeSchema.FactionTable;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FriendOrFoeDbHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "FriendOrFoe.db";

    public FriendOrFoeDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlString = "";

        sqlString += "create table " + FactionTable.NAME;
        sqlString += "( _id integer primary key autoincrement, ";
        sqlString += FactionTable.Cols.ID + ", ";
        sqlString += FactionTable.Cols.NAME + ", ";
        sqlString += FactionTable.Cols.STRENTH + ", ";
        sqlString += FactionTable.Cols.RELATIONSHIP + ")";

        db.execSQL(sqlString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int v1, int v2) {
        // More stuff
    }
}
