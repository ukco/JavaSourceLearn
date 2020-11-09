package cn.humblecodeukco.test.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author lyr
 * @Date 2020/11/9 14:49
 * @Version 1.0
 * @Description
 */
public class NioPractice {

    /**
     * ByteBuffer version
     * @throws FileNotFoundException
     */
    public void NioAccount() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("accounts.txt"));
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024*1024*32);
        try {
            while (true) {
                int eof = fileChannel.read(buffer);
                if (eof == -1) break;
                buffer.flip();
                int limit;
                for (limit = buffer.limit() - 1; buffer.get(limit) != '\n'; --limit);
                while (buffer.position() < limit) {
                    long id = 0;
                    char c;
                    while (true) {
                        c = (char) buffer.get();
                        if (c == ' ') break;
                        id = id * 10 + (c - '0');
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    while (true) {
                        c = (char) buffer.get();
                        if (c == '\n') break;
                        stringBuilder.append(c);
                    }
                    /*Account account = new Account(id, stringBuilder.toString());
                    Cluster cluster = new Cluster();
                    cluster.accountList.add(account);
                    cluster.srcid = id;
                    clusterList.add(cluster);*/
                }
                buffer.compact();
            }
            fileChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ByteBuffer version
     * @throws FileNotFoundException
     */
    public void NioRelation() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("relations.txt"));
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024 * 32);
        try {
            while (true) {
                int eof = fileChannel.read(buffer);
                if (eof == -1) break;
                buffer.flip();
                int limit;
                for (limit = buffer.limit() - 1; buffer.get(limit) != '\n'; --limit);
                processRelation(buffer, limit);
                buffer.compact();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Account Relation Process
     * @param buffer
     * @param limit
     */
    private void processRelation(ByteBuffer buffer, int limit) {
        while (buffer.position() < limit) {
            long fake_srcid = 0;
            long fake_destid = 0;
            char c;
            // 处理 fake_srcid
            while (true) {
                c = (char) buffer.get();
                if (c == ' ') break;
                fake_srcid = fake_srcid * 10 + (c - '0');
            }
            // 跳过 account
            c = buffer.getChar();
            while (c != ' ') c = (char) buffer.get();
            // 处理 fake_destid
            while (true) {
                c = (char) buffer.get();
                if (c == ' ') break;
                fake_destid = fake_destid * 10 + (c - '0');
            }
            // 将剩余 account读出
            while (c != '\n') c = (char) buffer.get();
        }
    }

    /**
     * MappedByteBuffer version
     * @throws IOException
     */
    public void NioMappedByteBufferAccount() throws IOException {
        File file = new File("accounts.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        long len = fileChannel.size();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        for (int i = 0; i < mappedByteBuffer.limit(); ++i) {

        }
    }

    public void nioMappedByteBufferWrite() throws Exception {
        RandomAccessFile rafo = new RandomAccessFile("result.txt", "rw");
        FileChannel fileChannel = rafo.getChannel();
        MappedByteBuffer writeBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0,
                fileChannel.size());
        /*for (int i = cluster_len; i < index.length; ++i) {
            if (index[i] == -1) {
                int ind=i-cluster_len;
                int x = computeNum(ind);
                while (mappedByteBuffer.get(x) != ' '){
                    writeBuffer.put(mappedByteBuffer.get(x));
                    ++x;
                }
                writeBuffer.put((byte) 0x20);
                for (int j=x+1;j<x+17;j++){
                    writeBuffer.put(mappedByteBuffer.get(j));
                }
                int k=index[ind];
                while (k!=-1){
                    writeBuffer.put((byte) 0x2C);
                    int pos=computeIndex(k);
                    for (int j = pos; j < pos + 16; ++j) writeBuffer.put(mappedByteBuffer.get(j));
                    k=index[k];
                }
                writeBuffer.put((byte) 0x0D);
                writeBuffer.put((byte) 0x0A);
            }
        }*/
        fileChannel.close();
        rafo.close();
    }

}
