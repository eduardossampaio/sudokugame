package com.apps.esampaio.sudoku.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.esampaio.sudoku.R
import com.apps.esampaio.sudoku.entity.SudokuGame
import kotlinx.android.synthetic.main.new_game_list_games_adapter.view.*

/**
 * Created by eduar on 07/04/2018.
 */

class ListGamesAdapter : RecyclerView.Adapter<ListGamesAdapter.ListGamesAdapterViewHolder> {
    val sudokuGames: List<SudokuGame>
    val context:Context
    var itemSelectedListener:ItemSelectedListener? = null

    constructor(context:Context,sudokuGames: List<SudokuGame>) {
        this.sudokuGames = sudokuGames;
        this.context = context;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListGamesAdapterViewHolder? {
        return ListGamesAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.new_game_list_games_adapter,null,false))
    }

    override fun onBindViewHolder(holder: ListGamesAdapterViewHolder, position: Int) {
        val sudokuGame = sudokuGames[position]
        holder.gameName.text = sudokuGame.gameName
        holder.sudokuBoard.sudokuGame = sudokuGame
        holder.itemView.setOnClickListener {
            itemSelectedListener?.onItemSelected(sudokuGame)
        }
        if(sudokuGame.isCompleted){
            holder.gameStatus.text = this.context.getString(R.string.completed)
        }else{
            holder.gameStatus.text = this.context.getString(R.string.not_completed)
        }
    }

    override fun getItemCount(): Int {
        return sudokuGames.size
    }
    fun setItemSelectedListener(listener: (SudokuGame)->Unit){
        itemSelectedListener = object : ItemSelectedListener{
            override fun onItemSelected(sudokuGames: SudokuGame) {
                listener(sudokuGames)
            }

        }
    }
    class ListGamesAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sudokuBoard = itemView.sudoku_board_view
        val gameName = itemView.game_name
        val gameStatus = itemView.game_status
    }

    interface ItemSelectedListener{
        fun onItemSelected(sudokuGames:SudokuGame)
    }
}
