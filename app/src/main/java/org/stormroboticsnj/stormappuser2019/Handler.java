package org.stormroboticsnj.stormappuser2019;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;



    /**
     * Created by sanju_000 on 1/15/2018.
     */

    public class  Handler extends SQLiteOpenHelper {
        //the database
        private static final int DB_VERSION = 5;
        private static final String DB_NAME = "matchNum";
        private static final String DB_TABLE = "matchDb";

        //column names
        private static final String COL_ID = "_id";
        private static final String COL_TEAM = "team_num";
        private static final String COL_ALLIANCE = "alliance";
        private static final String COL_MATCH = "match_num";
        private static final String COL_STARTING_POSITION = "starting_position";
        private static final String COL_PASS_AUTO_LINE = "pass_auto_line";
        private static final String COL_AUTO_HATCHES = "auto_hatches";
        private static final String COL_AUTO_CARGO = "auto_cargo";
        private static final String COL_CARGO_RT = "cargo_lvl3";
        private static final String COL_CARGO_RD = "cargo_lvl2";
        private static final String COL_CARGO_RU = "cargo_lvl1";
        private static final String COL_CARGO_SHIP = "cargo_ship";
        private static final String COL_CARGO_PLAYER = "cargo_player";
        private static final String COL_CARGO_GROUND = "cargo_ground";
        private static final String COL_HATCH_RT = "hatch_lvl3";
        private static final String COL_HATCH_RD = "hatch_lvl2";
        private static final String COL_HATCH_RU = "hatch_lvl1";
        private static final String COL_HATCH_SHIP = "hatch_ship";
        private static final String COL_HATCH_PLAYER = "hatch_player";
        private static final String COL_HATCH_GROUND = "hatch_ground";
        private static final String COL_SELF_LEVEL = "self_level";
        private static final String COL_ASSIST_LEVEL = "assist_level";
        private static final String COL_ASSIST_TWO_LEVEL = "assist_two_level";
        private static final String COL_SPECIAL_CASES = "special_cases";


        //needed for getinstance()
        private static Handler dbH = null;
        private Context ctx;

        //Default constructor
        public Handler(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        //Use only one instance of database, not many.
        public static Handler getInstance(Context context){
            if(dbH == null){
                dbH = new Handler(context.getApplicationContext());
            }
            return dbH;
        }

        public void onCreate(SQLiteDatabase db) {
            //Build SQL query to create the table
            String CREATE_TEAM = "CREATE TABLE " + DB_TABLE + "(" +
                    //create columns
                    COL_ID + " INTEGER PRIMARY KEY NOT NULL, " +
                    COL_TEAM + " INTEGER NOT NULL, " +
                    COL_MATCH + " INTEGER NOT NULL, " +
                    COL_ALLIANCE + " INTEGER NOT NULL, " +

                    COL_STARTING_POSITION + " INTEGER NOT NULL, " +
                    COL_PASS_AUTO_LINE + " INTEGER NOT NULL, " +
                    COL_AUTO_HATCHES + " INTEGER NOT NULL, " +
                    COL_AUTO_CARGO + " INTEGER NOT NULL, " +
                    COL_CARGO_RT + " INTEGER NOT NULL, " +
                    COL_CARGO_RD + " INTEGER NOT NULL, " +
                    COL_CARGO_RU + " INTEGER NOT NULL, " +
                    COL_CARGO_SHIP + " INTEGER NOT NULL, " +
                    COL_CARGO_PLAYER+ " INTEGER NOT NULL, " +
                    COL_CARGO_GROUND + " INTEGER NOT NULL, " +
                    COL_HATCH_RT + " INTEGER NOT NULL, " +
                    COL_HATCH_RD + " INTEGER NOT NULL, " +
                    COL_HATCH_RU + " INTEGER NOT NULL, " +
                    COL_HATCH_SHIP + " INTEGER NOT NULL, " +
                    COL_HATCH_PLAYER+ " INTEGER NOT NULL, " +
                    COL_HATCH_GROUND + " INTEGER NOT NULL, " +
                    COL_SELF_LEVEL + " INTEGER NOT NULL, " +
                    COL_ASSIST_LEVEL + " INTEGER NOT NULL, " +
                    COL_ASSIST_TWO_LEVEL + " INTEGER NOT NULL, "+
                    COL_SPECIAL_CASES + " INTEGER NOT NULL" + ")";
            //executes SQL query

            System.out.println("CREATE_TEAM: ");
            System.out.println(CREATE_TEAM);

            db.execSQL(CREATE_TEAM);

        }

        //If database structure changed, drop and rebuild. Should never actually be called.
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(db);
        }

        public void clearTable(){
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(DB_TABLE, null, null); //Drop the table, clear data
        }

        public void deleteDatabase() {
            SQLiteDatabase db = this.getWritableDatabase();
            ctx.deleteDatabase(db.getPath()); //Delete the database itself
        }

        //Creates a map data structure to add data
        public ContentValues addData(DeepSpace game){
            System.out.println("Game: " + game);
            ContentValues data = new ContentValues();
            data.put(COL_TEAM, game.getTeamNum());
            data.put(COL_MATCH, game.getMatchNum());
            data.put(COL_ALLIANCE, game.getAlliance());
            data.put(COL_STARTING_POSITION, game.getStartingPosition());
            data.put(COL_PASS_AUTO_LINE, game.getPassAutoLine());
            data.put(COL_AUTO_HATCHES, game.getAutoHatches());
            data.put(COL_AUTO_CARGO, game.getAutoCargo());
            data.put(COL_CARGO_RT, game.getCargoRT());
            data.put(COL_CARGO_RD, game.getCargoRD());
            data.put(COL_CARGO_RU, game.getCargoRU());
            data.put(COL_CARGO_SHIP, game.getCargoShip());
            data.put(COL_CARGO_PLAYER, game.getCargoPlayer());
            data.put(COL_CARGO_GROUND, game.getCargoGround());
            data.put(COL_HATCH_RT, game.getHatchRT());
            data.put(COL_HATCH_RD, game.getHatchRD());
            data.put(COL_HATCH_RU, game.getHatchRU());
            data.put(COL_HATCH_SHIP, game.getHatchShip());
            data.put(COL_HATCH_PLAYER, game.getHatchPlayer());
            data.put(COL_HATCH_GROUND, game.getHatchGround());
            data.put(COL_SELF_LEVEL, game.getSelfLevel());
            data.put(COL_ASSIST_LEVEL, game.getAssistLevel());
            data.put(COL_ASSIST_TWO_LEVEL, game.getAssistTwoLevel());
            data.put(COL_SPECIAL_CASES, game.getSpecialCases());
            System.out.println("Data: " + data);
            return data;
        }

        //Insert ContentValues into table
        public void addAllData(DeepSpace game){
            List<String[]> list = new ArrayList<>();
            SQLiteDatabase db = this.getWritableDatabase();
            String query = "SELECT * FROM " + DB_TABLE;
            Cursor cursor = db.rawQuery(query, null);
            System.out.println("ALL COL NAMES: ");
            for (String name:cursor.getColumnNames()){
                System.out.println("    " + name);
            }

            // SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = addData(game);
            db.insert(DB_TABLE, null, values);
            Log.d("DB", "Data added");
            db.close(); //Frees database resource
        }

        public List<DeepSpace> getAllTeams(){
            List<DeepSpace> list = new ArrayList<>();
            SQLiteDatabase db = this.getWritableDatabase();
            String query = "SELECT * FROM " + DB_TABLE;
            //Cursor executes queries
            Cursor cursor = db.rawQuery(query, null);

            //Makes sure that cursor can start at the dataset
            if(cursor.moveToFirst()) {
                do {
                    DeepSpace tmp = new DeepSpace();
                    //cursor.getint/getstring gets the value as the datatype from a column index
                    tmp.setTeamNum(cursor.getInt(cursor.getColumnIndex(COL_TEAM))); //0
                    tmp.setMatchNum(cursor.getInt(cursor.getColumnIndex(COL_MATCH))); //1
                    tmp.setAlliance(cursor.getInt(cursor.getColumnIndex(COL_ALLIANCE))); //2
                    tmp.setStartingPosition(cursor.getInt(cursor.getColumnIndex(COL_STARTING_POSITION))); //3
                    tmp.setPassAutoLine(cursor.getInt(cursor.getColumnIndex(COL_PASS_AUTO_LINE))); //4
                    tmp.setAutoHatches(cursor.getInt(cursor.getColumnIndex(COL_AUTO_HATCHES))); //5
                    tmp.setAutoCargo(cursor.getInt(cursor.getColumnIndex(COL_AUTO_CARGO))); //6
                    tmp.setCargoRT(cursor.getInt(cursor.getColumnIndex(COL_CARGO_RT))); //7
                    tmp.setCargoRD(cursor.getInt(cursor.getColumnIndex(COL_CARGO_RD))); //8
                    tmp.setCargoRU(cursor.getInt(cursor.getColumnIndex(COL_CARGO_RU))); //9
                    tmp.setCargoShip(cursor.getInt(cursor.getColumnIndex(COL_CARGO_SHIP))); //10
                    tmp.setCargoPlayer(cursor.getInt(cursor.getColumnIndex(COL_CARGO_PLAYER))); //11
                    tmp.setCargoGround(cursor.getInt(cursor.getColumnIndex(COL_CARGO_GROUND))); //12
                    tmp.setHatchRT(cursor.getInt(cursor.getColumnIndex(COL_HATCH_RT))); //13
                    tmp.setHatchRD(cursor.getInt(cursor.getColumnIndex(COL_HATCH_RD))); //14
                    tmp.setHatchRU(cursor.getInt(cursor.getColumnIndex(COL_HATCH_RU))); //15
                    tmp.setHatchShip(cursor.getInt(cursor.getColumnIndex(COL_HATCH_SHIP))); //16
                    tmp.setHatchPlayer(cursor.getInt(cursor.getColumnIndex(COL_HATCH_PLAYER))); //17
                    tmp.setHatchGround(cursor.getInt(cursor.getColumnIndex(COL_HATCH_GROUND))); //18
                    tmp.setSelfLevel(cursor.getInt(cursor.getColumnIndex(COL_SELF_LEVEL)));//19
                    tmp.setAssistTwoLevel(cursor.getInt(cursor.getColumnIndex(COL_ASSIST_LEVEL)));//20
                    tmp.setAssistTwoLevel(cursor.getInt(cursor.getColumnIndex(COL_ASSIST_TWO_LEVEL)));//21
                    tmp.setSpecialCases(cursor.getInt(cursor.getColumnIndex(COL_SPECIAL_CASES))); //22
                    list.add(tmp);
                    //makes sure it executes so long as there is new entries to look at
                } while (cursor.moveToNext());
            }
            return list;
        }

        public List<String[]> getAllTeamsStr(){
            List<String[]> list = new ArrayList<>();
            SQLiteDatabase db = this.getWritableDatabase();
            String query = "SELECT * FROM " + DB_TABLE;
            Cursor cursor = db.rawQuery(query, null);

            if(cursor.moveToFirst()) {
                do {
                    String[] tmp = new String[19];
                    tmp[0] = cursor.getInt(cursor.getColumnIndex(COL_TEAM)) + "";
                    tmp[1] = cursor.getInt(cursor.getColumnIndex(COL_MATCH)) + "";
                    tmp[2] = cursor.getInt(cursor.getColumnIndex(COL_ALLIANCE)) + "";
                    tmp[3] = cursor.getInt(cursor.getColumnIndex(COL_STARTING_POSITION)) + "";
                    tmp[4] = cursor.getInt(cursor.getColumnIndex(COL_PASS_AUTO_LINE)) + "";
                    tmp[5] = cursor.getInt(cursor.getColumnIndex(COL_AUTO_HATCHES)) + "";
                    tmp[6] = cursor.getInt(cursor.getColumnIndex(COL_AUTO_CARGO)) + "";
                    tmp[7] = cursor.getInt(cursor.getColumnIndex(COL_CARGO_RT)) + "";
                    tmp[8] = cursor.getInt(cursor.getColumnIndex(COL_CARGO_RD)) + "";
                    tmp[9] = cursor.getInt(cursor.getColumnIndex(COL_CARGO_RU)) + "";
                    tmp[10] = cursor.getInt(cursor.getColumnIndex(COL_CARGO_SHIP)) + "";
                    tmp[11] = cursor.getInt(cursor.getColumnIndex(COL_CARGO_PLAYER)) + "";
                    tmp[12] = cursor.getInt(cursor.getColumnIndex(COL_CARGO_GROUND)) + "";
                    tmp[13] = cursor.getInt(cursor.getColumnIndex(COL_HATCH_RT)) + "";
                    tmp[14] = cursor.getInt(cursor.getColumnIndex(COL_HATCH_RD)) + "";
                    tmp[15] = cursor.getInt(cursor.getColumnIndex(COL_HATCH_RU)) + "";
                    tmp[16] = cursor.getInt(cursor.getColumnIndex(COL_HATCH_SHIP)) + "";
                    tmp[17] = cursor.getInt(cursor.getColumnIndex(COL_HATCH_PLAYER)) + "";
                    tmp[18] = cursor.getInt(cursor.getColumnIndex(COL_HATCH_GROUND)) + "";
                    tmp[19] = cursor.getInt(cursor.getColumnIndex(COL_SELF_LEVEL)) + "";
                    tmp[20] = cursor.getInt(cursor.getColumnIndex(COL_ASSIST_LEVEL)) + "";
                    tmp[21] = cursor.getInt(cursor.getColumnIndex(COL_ASSIST_TWO_LEVEL)) + "";
                    tmp[22] = cursor.getInt(cursor.getColumnIndex(COL_SPECIAL_CASES)) + "";
                    list.add(tmp);
                } while (cursor.moveToNext());
            }
            return list;
        }
        public void deleteFromDB(DeepSpace deepSpace){
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(DB_TABLE, COL_TEAM + "=?" + " AND " + COL_MATCH + "=?", new String[]{String.valueOf(deepSpace.getTeamNum()), String.valueOf(deepSpace.getMatchNum())});
            db.close();
        }

        public int getDBSize(){
            SQLiteDatabase db = this.getWritableDatabase();
            String query = "SELECT * FROM " + DB_TABLE;
            Cursor cursor = db.rawQuery(query, null);
            int count = 0;
            if(cursor.moveToFirst()) do{++count;}while(cursor.moveToNext());
            return count;
        }
}
