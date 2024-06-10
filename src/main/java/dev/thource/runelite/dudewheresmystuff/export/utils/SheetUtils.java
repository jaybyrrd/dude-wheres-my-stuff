package dev.thource.runelite.dudewheresmystuff.export.utils;

import com.google.api.services.sheets.v4.model.GridRange;

public class SheetUtils {
  private static String convertToTitle(int columnNumber) {
    StringBuilder result = new StringBuilder();
    while (columnNumber > 0) {
      columnNumber--;
      char c = (char) ('A' + columnNumber % 26);
      result.insert(0, c);
      columnNumber /= 26;
    }
    return result.toString();
  }

  private int titleToNumber(String ct) {
    int result = 0;
    for (int i = 0; i < ct.length(); i++) {
      result = result * 26 + ct.charAt(i) - 'A' + 1;
    }
    return result;
  }

  private static String getCellId(int columnNumber, int row) {
    return convertToTitle(columnNumber) + row;
  }

  public static String getRange(
      String displayName, int startColumnNumber, int startRow, int endColumnNumber, int endRow) {
    return String.format(
        "%s!%s:%s",
        displayName, getCellId(startColumnNumber, startRow), getCellId(endColumnNumber, endRow));
  }

  public static GridRange getGridRange(
      int sheetId, int startColumnNumber, int startRow, int endColumnNumber, int endRow) {
    return new GridRange()
        .setSheetId(sheetId)
        .setStartColumnIndex(startColumnNumber)
        .setStartRowIndex(startRow)
        .setEndColumnIndex(endColumnNumber)
        .setEndRowIndex(endRow);
  }
}
