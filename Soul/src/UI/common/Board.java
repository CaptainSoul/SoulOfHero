package UI.common;

import org.omg.CORBA.PUBLIC_MEMBER;

import character.Sprite;

public class Board {
        private int boardWidth;
		private int boardHeight;
        private boolean isDraging = false;
        private String title;
        private boolean dragable;
        
        /**
         * 
         * @param width                   面板宽
         * @param height                  面板高
         * @param backgroundColor        面板背景颜色	(未设置)
         * @param backgroundAlpha        面板背景透明度(已删除)
         * @param title                   面板标题文字，若为空字符串，则不会创建标题栏
         * @param dragable        是否允许拖动，若为true，则可通过点击标题栏进行面板拖动
         * 
         */
        public Board  ( int boardWidth, int boardHeight, String title){
        	this.boardWidth = boardWidth;
        	this.boardHeight = boardHeight;
        	this.title = title;
        	this.dragable = false;
        }
        
        /**
         * 为面板添加子元素 
         * @param instance        		      子元素实例
         * @param x                        子元素将要添加到的横坐标位置
         * @param y                        子元素将要添加到的纵坐标位置
         * 
         */                
 
        
//----------------------下面开始是读写器-----------------------------//                
        public int getBoardWidth() {
 			return boardWidth;
 		}

 		public void setBoardWidth(int boardWidth) {
 			this.boardWidth = boardWidth;
 		}

 		public int getBoardHeight() {
 			return boardHeight;
 		}

 		public void setBoardHeight(int boardHeight) {
 			this.boardHeight = boardHeight;
 		}

 		public String getTitle() {
 			return title;
 		}

 		public void setTitle(String title) {
 			this.title = title;
 		}

 		public boolean isDragable() {
 			return dragable;
 		}

 		public void setDragable(boolean dragable) {
 			this.dragable = dragable;
 		}

 		public void setDraging(boolean isDraging) {
 			this.isDraging = isDraging;
 		}
}