package com.iman.inc.doadzikirhisnulmuslim.helper;

import android.provider.BaseColumns;

/**
 * Created by z on 20/03/18.
 */

public class MyConstant  {


    public static final String DBNAME = "HMuslim";


    public static final class table_Judul implements BaseColumns{
        public static final String TABLE_NAME  = "judulDoa";
        public static final String COL_idUtama = "_idUtama";
        public static final String COL_IDBag = "IDBag";
        public static final String COL_BagName = "BagName";
        public static final String COL_Kat  = "Kat";
        public static final String COL_DoaName  = "DoaName";

    }

}
