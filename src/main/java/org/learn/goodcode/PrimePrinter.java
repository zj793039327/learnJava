/*
 * Copyright (C) 2023 Baidu, Inc. All Rights Reserved.
 */
package org.learn.goodcode;

public class PrimePrinter {
    public static void main(String[] args) {
        final int NUMBER_OF_PRIMES = 1000;
        int[] primes = PrimeGenerator.generatePrimes(NUMBER_OF_PRIMES);
        final int ROWS_PER_PAGE = 50;
        final int COLUMNS_PER_PAGE = 4;
        RowColumnPagePrinter tablePrinter =
                new RowColumnPagePrinter(ROWS_PER_PAGE,
                        COLUMNS_PER_PAGE,
                        "The First " + NUMBER_OF_PRIMES +
                                " Prime Numbers");
        tablePrinter.print(primes);
    }
}
//
//abstract public class Sql {
//    public Sql(String table, Column[] columns)
//    abstract public String generate();
//}
//public class CreateSql extends Sql {
//    public CreateSql(String table, Column[] columns)
//    @Override public String generate()
//}
//public class SelectSql extends Sql {
//    public SelectSql(String table, Column[] columns)
//    @Override public String generate()
//}
//public class InsertSql extends Sql {
//    public InsertSql(String table, Column[] columns, Object[] fields)
//    @Override public String generate()
//    private String valuesList(Object[] fields, final Column[] columns)
//}
//public class SelectWithCriteriaSql extends Sql {
//    public SelectWithCriteriaSql(
//            String table, Column[] columns, Criteria criteria)
//    @Override public String generate()
//}
//public class SelectWithMatchSql extends Sql {
//    public SelectWithMatchSql(
//            String table, Column[] columns, Column column, String pattern)
//    @Override public String generate()
//}
//public class FindByKeySql extends Sql
//        public FindByKeySql(
//                String table, Column[] columns, String keyColumn, String keyValue)
//        @Override public String generate()
//}
//public class PreparedInsertSql extends Sql {
//    public PreparedInsertSql(String table, Column[] columns)
//    @Override public String generate() {
//        private String placeholderList(Column[] columns)
//    }
//    public class Where {
//        public Where(String criteria)
//        public String generate()
//    }