package balloons.objetos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class CloudGhost extends BalloonsObjetos{
    private Sprite sprite;

    public CloudGhost(Texture texture, float posicaoX, float posicaoY){
        this.tamanho = 270;
        this.sprite = new Sprite(texture);
        this.coordenadaX = posicaoX;;
        this.coordenadaY = posicaoY;
        this.sprite.setSize(tamanho,10*tamanho/9);
        if(coordenadaX + tamanho > Gdx.graphics.getWidth())
            coordenadaX = Gdx.graphics.getWidth() - tamanho;
        this.sprite.setPosition(coordenadaX,coordenadaY);
    }

    public Sprite getSprite() {
        return sprite;
    }
}
