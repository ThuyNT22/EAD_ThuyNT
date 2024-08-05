package org.example.eadtest_thuynt.utils.encryption;

public enum AESKeySize {
    KEY_128(128),
    KEY_192(192),
    KEY_256(256);

    private int keySize;

    AESKeySize(int keySize) {
        this.keySize = keySize;
    }

    public int getKeySize() {
        return this.keySize;
    }
}
