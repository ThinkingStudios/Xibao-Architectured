package org.teacon.xibao.util;

import net.minecraft.sound.MusicSound;
import net.minecraft.util.Identifier;

public enum XibaoType {
    XIBAO(
            XiBaoMusic.XIBAO_MUSIC,
            new Identifier("xibaopp", "textures/xibao.png"),
            new Identifier[] {
        new Identifier("xibaopp", "textures/yellow_snow.png"),
                new Identifier("xibaopp", "textures/red_snow.png")
    },
            "xibao"
            ),
    BEIBAO(
            XiBaoMusic.BEIBAO_MUSIC,
            new Identifier("xibaopp", "textures/beibao.png"),
            new Identifier[] {
        new Identifier("xibaopp", "textures/white_snow.png")
    },
            "beibao"
            )
    ;
    public final MusicSound music;
    public final Identifier background;
    public final Identifier[] snows;
    public final String type;

    XibaoType(MusicSound music, Identifier background, Identifier[] snows, String type) {
        this.music = music;
        this.background = background;
        this.snows = snows;
        this.type = type;
    }

    public static XibaoType getByString(String type) {
        for (XibaoType xibaoType : values()) {
            if (type.equals(xibaoType.type)) return xibaoType;
        }
        return XIBAO;
    }
}
