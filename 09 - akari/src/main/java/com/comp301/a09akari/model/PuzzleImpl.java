package com.comp301.a09akari.model;

public class PuzzleImpl implements Puzzle {
  private final int[][] board;
  private final int height;
  private final int width;

  public PuzzleImpl(int[][] board) {
    this.board = board;
    this.width = board[0].length;
    this.height = board.length;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public CellType getCellType(int r, int c) {
    if (!inPuzzle(r, c)) {
      throw new IndexOutOfBoundsException();
    } else {
      int temp = board[r][c];
      if (temp <= 4) {
        return CellType.CLUE;
      } else if (temp == 5) {
        return CellType.WALL;
      } else {
        return CellType.CORRIDOR;
      }
    }
  }

  @Override
  public int getClue(int r, int c) {
    if (getCellType(r, c) == CellType.CLUE) {
      return board[r][c];
    } else {
      throw new IllegalArgumentException();
    }
  }

  private boolean inPuzzle(int r, int c) {
    return r < getHeight() && c < getWidth() && r >= 0 && c >= 0;
  }
}
