package au.edu.curtin.friendorfoe;

import au.edu.curtin.friendorfoe.FriendOrFoeSchema.FactionTable;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/**
 * Maintains the overall dataset; specifically of course all the different factions.
 */
public class FactionList {
    private SQLiteDatabase db;
    private List<Faction> factions = new ArrayList<>();

    public FactionList() {}

    public FactionList(Context context) {
        this.db = new FriendOrFoeDbHelper(
            context.getApplicationContext()
        ).getWritableDatabase();
    }

    public void load() {
        // ...
    }

    public int size() {
        return factions.size();
    }

    public Faction get(int i) {
        return factions.get(i);
    }

    public int add(Faction newFaction) {
        factions.add(newFaction);

        // Update Database
        ContentValues cv = createRow(newFaction);
        db.insert(FactionTable.NAME, null, cv);

        return factions.size() - 1; // Return insertion point
    }

    public void edit(Faction newFaction) {
        ContentValues cv = createRow(newFaction);
        String whereClause = FactionTable.Cols.ID + " = ?";
        String[] whereArgs = {String.valueOf(newFaction.getId())};
        db.update(FactionTable.NAME, cv, whereClause, whereArgs);
    }

    public void remove(Faction rmFaction) {
        factions.remove(rmFaction);

        String whereClause = FactionTable.Cols.ID + " = ?";
        String[] whereArgs = {String.valueOf(rmFaction.getId())};
        db.delete(FactionTable.NAME, whereClause, whereArgs);
    }

    private ContentValues createRow(Faction faction) {
        ContentValues cv = new ContentValues();

        cv.put(FactionTable.Cols.ID, faction.getId());
        cv.put(FactionTable.Cols.NAME, faction.getName());
        cv.put(FactionTable.Cols.STRENTH, faction.getStrength());
        cv.put(FactionTable.Cols.RELATIONSHIP, faction.getRelationship());

        return cv;
    }
}
