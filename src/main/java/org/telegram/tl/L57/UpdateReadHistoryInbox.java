/*
 *     This file is part of Telegram Server
 *     Copyright (C) 2015  Aykut Alparslan KOÇ
 *
 *     Telegram Server is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Telegram Server is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class UpdateReadHistoryInbox extends org.telegram.tl.TLUpdate {

    public static final int ID = 0x9961fd5c;

    public org.telegram.tl.TLPeer peer;
    public int max_id;
    public int pts;
    public int pts_count;

    public UpdateReadHistoryInbox() {
    }

    public UpdateReadHistoryInbox(org.telegram.tl.TLPeer peer, int max_id, int pts, int pts_count) {
        this.peer = peer;
        this.max_id = max_id;
        this.pts = pts;
        this.pts_count = pts_count;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        peer = (org.telegram.tl.TLPeer) buffer.readTLObject(APIContext.getInstance());
        max_id = buffer.readInt();
        pts = buffer.readInt();
        pts_count = buffer.readInt();
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(24);
        serializeTo(buffer);
        return buffer;
    }


    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeTLObject(peer);
        buff.writeInt(max_id);
        buff.writeInt(pts);
        buff.writeInt(pts_count);
    }


    public int getConstructor() {
        return ID;
    }
}