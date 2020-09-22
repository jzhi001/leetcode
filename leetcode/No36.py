class Solution:
    def isValidSudoku(self, board):
        #valid rows
        for r in range(9):
            if not self.valid(board, self.rowGenerator(r)):
                return False
        #valid cols
        for c in range(9):
            if not self.valid(board, self.colGenerator(c)):
                return False
        #valid sub grids
        for rnw in range(0, 9, 3):
            for cnw in range(0, 9, 3):
                if not self.valid(board, self.subGridGenerator(rnw, cnw)):
                    return False
        return True
        
    def rowGenerator(self, r):
        for c in range(9):
            yield r, c
    def colGenerator(self, c):
        for r in range(9):
            yield r, c
            
    def subGridGenerator(self, rnw, cnw):
        for offr in range(3):
            for offc in range(3):
                yield (rnw+offr, cnw+offc)
        
    def valid(self, board, generator):
        s = {str(x) for x in range(1,10)}
        for r, c in generator:
            x = board[r][c]
            if x == '.':
                continue
            elif x not in s:
                return False
            else:
                s.remove(x)
        return True
        
