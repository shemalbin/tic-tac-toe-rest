package tictactoerest.tictactoerest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.EBoardMark;
import domain.TicTacToe;
import service.ITicTaeToeService;

/**
 * @author Albin Shema
 * @FileName: TicTacToeController.java
 * @Date: Jan 19, 2020
 * @ProjectName: tic-tac-toe-rest
 */
@RestController
@RequestMapping("/tictactoe")
public class TicTacToeController {
	
	@Autowired
	private ITicTaeToeService ticTacToeService;
	
	@GetMapping(value="/")
	public TicTacToe initializeGame() {
		TicTacToe ticTacToe = new TicTacToe();
		TicTacToe ticTacToeResult = ticTacToeService.initializeTheBoard(ticTacToe);
		return ticTacToeResult;
	}
	
	@GetMapping(value = "/board/{board}/row/{row}/col/{col}")
    public int[] getTicketsNumberByStatusPriorityAndIssuer(@PathVariable(value = "board") String[] board,
    		@PathVariable(value = "row") int row, @PathVariable(value = "col") int col) {
		EBoardMark [][] boardMark = populateBoard(board);
		int [] result = ticTacToeService.getBestMove(boardMark);
		return result;
    }
	
	private EBoardMark [][] populateBoard(String[] board){
		EBoardMark [] boardMarkValues = new EBoardMark [9];
		EBoardMark [][] boardMark = new EBoardMark [3][3];
		for(int i=0; i<board.length; i++) {
		  if(board[i].equals("x")) {
			  boardMarkValues[i] = EBoardMark.CROSS;
		  } else if(board[i].equals("o")) {
			  boardMarkValues[i] = EBoardMark.CIRCLE;
		  } else if(board[i].equals("")) {
			  boardMarkValues[i] = EBoardMark.EMPTY;
		  }
	   }
		int count = 0;
	   
		for(int i=0; i<TicTacToe.getRows(); i++) {
			for(int j=0; j<TicTacToe.getColumns(); j++) {
				boardMark[i][j] = boardMarkValues[count];
				count++;
			}
		}
		return boardMark;
	}
}
