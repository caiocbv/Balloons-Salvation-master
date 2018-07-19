package balloons.niveis;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

import java.util.LinkedList;
import java.util.List;
import balloons.objetos.Aviao;
import balloons.objetos.Passaro;
import balloons.objetos.CloudGhost;

public class BallonsNivel1 {
    private Pixmap mapa;
    private List<CloudGhost> cloudGhosts;
    private List<Passaro> passaros;
    private List<Aviao> avioes;

    public BallonsNivel1(){
        this.mapa = new Pixmap(Gdx.files.internal("nivel_1.png"));
        this.cloudGhosts = new LinkedList<CloudGhost>();
        this.passaros = new LinkedList<Passaro>();
        this.avioes = new LinkedList<Aviao>();
        init();
    }

    public enum PIXEL_TIPO{
        PIPA(0, 255, 0),
        AVIAO(255, 255, 255),
        PASSARO(0, 0, 255);

        private int cor;

        private PIXEL_TIPO (int r, int g, int b) {
            cor = r << 24 | g << 16 | b << 8 | 0xff;
        }

        public boolean mesmaCor (int cor) {
            return this.cor == cor;
        }

        public int getColor () {
            return cor;
        }
    }

    private void init(){
        int currentPixel;
        Texture aviaoTexture = new Texture("aviao_papel.png");
        Texture pipaTexture = new Texture("pipa.png");
        Texture passaroTexture = new Texture("passaro.png");
        float escala = Gdx.graphics.getWidth() / mapa.getWidth();
        for(int pixelY = 0; pixelY < mapa.getHeight(); pixelY++ ){
            for(int pixelX = 0; pixelX < mapa.getWidth(); pixelX++){
                currentPixel = mapa.getPixel(pixelX,pixelY);
                if(PIXEL_TIPO.AVIAO.mesmaCor(currentPixel)){
                    avioes.add(new Aviao(aviaoTexture, pixelX * escala, (mapa.getHeight() - pixelY) * escala));
                }else if(PIXEL_TIPO.PASSARO.mesmaCor(currentPixel)){
                    passaros.add(new Passaro(passaroTexture, pixelX * escala, (mapa.getHeight() - pixelY) * escala));
                }else if(PIXEL_TIPO.PIPA.mesmaCor(currentPixel)){
                    cloudGhosts.add(new CloudGhost(pipaTexture,pixelX * escala, (mapa.getHeight() - pixelY) * escala));
                }
            }
        }
    }

    public CloudGhost[] getCloudGhosts(){
        CloudGhost[] cloudGhosts = new CloudGhost[this.cloudGhosts.size()];
        for(int i = 0; i < this.cloudGhosts.size(); i++){
            cloudGhosts[i] = this.cloudGhosts.get(i);
        }
        return cloudGhosts;
    }

    public Aviao[] getAvioes(){
        Aviao[] avioes = new Aviao[this.avioes.size()];
        for(int i = 0; i < this.avioes.size(); i++){
            avioes[i] = this.avioes.get(i);
        }
        return avioes;
    }

    public Passaro[] getPassaros(){
        Passaro[] passaros = new Passaro[this.passaros.size()];
        for(int i = 0; i < this.passaros.size(); i++){
            passaros[i] = this.passaros.get(i);
        }
        return passaros;
    }
}
