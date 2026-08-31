package br.com.poo.fantasy_quest.main;

/**
 *  @author inctr
 *  
 *  Aqui as configurações iniciais da aplicação. Talvez fosse melhor criar um package para o Game, mas por ora deixamos assim
 * 
 */
public final class GameConfig 
{
    public static final int ORIGINAL_TILE_SIZE = 16;
    public static final int SCALE = 3;
    public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // ps: nossas imagens devem ter 48x48 para preencher um tile

    public static final int MAX_SCREEN_COL = 16;
    public static final int MAX_SCREEN_ROW = 12;

    public static final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;   // 16 * 48 = 768 px
    public static final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;  // 12 * 48 = 576 px

    public static final int	   FPS = 60;
    public static final double TIME_STEP = 1.0/FPS; // timestep fixo pq o jogo atualiza a lógica sempre no mesmo intervalo de tempo 0,01666... segundos
}
